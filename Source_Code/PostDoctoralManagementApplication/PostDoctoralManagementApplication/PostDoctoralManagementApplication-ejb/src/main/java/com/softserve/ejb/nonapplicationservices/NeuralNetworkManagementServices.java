/*
 * This file is copyrighted to the authors stated below.
 * Any duplication or modifications or usage of the file's contents               
 * that is not approved by the stated authors is prohibited.
 */

package com.softserve.ejb.nonapplicationservices;

import com.softserve.auxiliary.factories.DAOFactory;
import com.softserve.auxiliary.factories.DBEntitiesFactory;
import com.softserve.auxiliary.interceptors.AuditTrailInterceptor;
import com.softserve.auxiliary.interceptors.AuthenticationInterceptor;
import com.softserve.auxiliary.requestresponseclasses.NeuralNetworkCreationRequest;
import com.softserve.auxiliary.requestresponseclasses.Session;
import com.softserve.auxiliary.transactioncontrollers.TransactionController;
import com.softserve.persistence.DBDAO.NeuralNetworkJpaController;
import com.softserve.persistence.DBDAO.NeuronJpaController;
import com.softserve.persistence.DBDAO.SynapseJpaController;
import com.softserve.persistence.DBEntities.NeuralNetwork;
import com.softserve.persistence.DBEntities.Neuron;
import com.softserve.persistence.DBEntities.Synapse;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author SoftServe Group [ Mathys Ellis (12019837) Kgothatso Phatedi Alfred
 * Ngako (12236731) Tokologo Machaba (12078027) ]
 */
@Interceptors({AuditTrailInterceptor.class, AuthenticationInterceptor.class})
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class NeuralNetworkManagementServices implements NeuralNetworkManagementServicesLocal {
    @PersistenceUnit(unitName = com.softserve.auxiliary.constants.PersistenceConstants.WORKING_DB_PERSISTENCE_UNIT_NAME)
    private EntityManagerFactory emf;

    public NeuralNetworkManagementServices() {
    }

    public NeuralNetworkManagementServices(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    protected DAOFactory getDAOFactory(EntityManager em)
    {
	return new DAOFactory(em);
    }
    
    protected DBEntitiesFactory getDBEntitiesFactory()
    {
        return new DBEntitiesFactory();
    }

    protected TransactionController getTransactionController()
    {
        return new TransactionController(emf);
    }
    
    protected GregorianCalendar getGregorianCalendar()
    {
        return new GregorianCalendar();
    }
    
    protected EntityManager createEntityManager()
    {
        return emf.createEntityManager();
    }

    @Override
    public List<NeuralNetwork> loadAllNeuralNetworks(Session session) throws Exception 
    {
        EntityManager em = createEntityManager();

        try
        {
            return getDAOFactory(em).createNeuralNetworkDAO().findNeuralNetworkEntities();
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public NeuralNetwork getDefaultNeuralNetwork(Session session) throws Exception 
    {
        EntityManager em = createEntityManager();

        try
        {
            return getDAOFactory(em).createNeuralNetworkDAO().findTheDefaultNeuralNetwork();
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public void createNeuralNetwork(Session session, NeuralNetworkCreationRequest neuralNetworkCreationRequest) throws Exception 
    {
        TransactionController transactionController = getTransactionController();
        transactionController.StartTransaction();
        NeuralNetwork neuralNetwork;
        try
        {
            DAOFactory dAOFactory = transactionController.getDAOFactoryForTransaction();
            DBEntitiesFactory dBEntitiesFactory = getDBEntitiesFactory();
            NeuronJpaController neuronJpaController = dAOFactory.createNeuronDAO();
            SynapseJpaController synapseJpaController = dAOFactory.createSynapseDAO();
            
            neuralNetwork = dBEntitiesFactory.createNeuralNetwork(neuralNetworkCreationRequest.getName(), neuralNetworkCreationRequest.getType(), Boolean.FALSE, neuralNetworkCreationRequest.getBiasValue(), neuralNetworkCreationRequest.getMomentum(), neuralNetworkCreationRequest.getLearningRate(), neuralNetworkCreationRequest.getLowerCertaintyBound(), neuralNetworkCreationRequest.getUpperCertiantyBound(), neuralNetworkCreationRequest.getSmoothingParameter());
            
            neuralNetwork.setTimestamp(getGregorianCalendar().getTime());
            
            
            
            //Create input neurons + 1 for bias neuron
            List<Neuron> inputNeurons = new ArrayList<Neuron>();
            
            for(int i = 0; i < neuralNetworkCreationRequest.getNumberOfInputNeurons() + 1; i++)
            {
                Neuron neuron = dBEntitiesFactory.createNeuron(neuralNetwork, new BigInteger(Integer.toString(i)));
                if(i == neuralNetworkCreationRequest.getNumberOfInputNeurons())
                {
                    neuron.setBiasNeuron(Boolean.TRUE);
                    neuron.setValue(neuralNetwork.getBiasThreshold());
                    
                }
                else
                {
                    neuron.setBiasNeuron(Boolean.FALSE);
                }
                neuralNetwork.getNeuronList().add(neuron);
                neuronJpaController.create(neuron);
                inputNeurons.add(neuron);            
            }
            
            //Create hidden layers and synapses             
            List<Neuron> prevNeurons = inputNeurons;
            
            for(int i = 0; i < neuralNetworkCreationRequest.getNumberOfHiddenLayers(); i++)
            {
                List<Neuron> curNeurons = new ArrayList<Neuron>();
                
                for(int k = 0; k < neuralNetworkCreationRequest.getNumberOfHiddenNeuronsPerLayer().get(i)+ 1; k++)
                {
                    Neuron neuron = dBEntitiesFactory.createNeuron(neuralNetwork, new BigInteger(Integer.toString(k)));
                    if(k == neuralNetworkCreationRequest.getNumberOfHiddenNeuronsPerLayer().get(i))
                    {
                        neuron.setBiasNeuron(Boolean.TRUE);
                        neuron.setValue(neuralNetwork.getBiasThreshold());
                    }
                    else
                    {
                        neuron.setBiasNeuron(Boolean.FALSE);
                    }
                    
                    neuralNetwork.getNeuronList().add(neuron);
                    neuronJpaController.create(neuron);
                    curNeurons.add(neuron);
                    
                    if(k < neuralNetworkCreationRequest.getNumberOfHiddenNeuronsPerLayer().get(i))
                    {
                        for(Neuron neuron1 : prevNeurons)
                        {
                            Synapse synapse = dBEntitiesFactory.createSynapse(neuralNetwork,neuron1,neuron,0.0);
                            neuralNetwork.getSynapseList().add(synapse);
                            synapseJpaController.create(synapse);                    
                        }
                    }
                }                
                prevNeurons = curNeurons;
            }
            
            //Create output neurons and synapse            
            for(int i = 0; i < neuralNetworkCreationRequest.getNumberOfOutputNeurons(); i++)
            {
                Neuron neuron = dBEntitiesFactory.createNeuron(neuralNetwork, new BigInteger(Integer.toString(i)));
    
                neuron.setBiasNeuron(Boolean.FALSE);

                neuronJpaController.create(neuron); 
                
                for(Neuron neuron1 : prevNeurons)
                {
                    Synapse synapse = dBEntitiesFactory.createSynapse(neuralNetwork,neuron1,neuron,0.0);
                    neuralNetwork.getSynapseList().add(synapse);
                    synapseJpaController.create(synapse);                    
                }
                
            }
            
            dAOFactory.createNeuralNetworkDAO().create(neuralNetwork);
            
            transactionController.CommitTransaction();
            
            
        }
        catch(Exception ex)
        {
            transactionController.RollbackTransaction();
            throw ex;
        }
        finally
        {
            transactionController.CloseEntityManagerForTransaction();
        }
        
        EntityManager em = createEntityManager();
        try
        {
            if(neuralNetwork != null)
            {
                neuralNetwork = getDAOFactory(em).createNeuralNetworkDAO().findNeuralNetwork(neuralNetwork.getNeuralnetworkID());
                System.out.println(neuralNetwork.getNeuralnetworkID() + " " + neuralNetwork.getSynapseList().toString());
                neuralNetwork.initaliseNetwork();
                updateNeuralNetwork(session, neuralNetwork);
                System.out.println(neuralNetwork.blackBoxToString());
            }
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public void makeNeuralNetworkDefaultNetwork(Session session, NeuralNetwork neuralnetwork) throws Exception 
    {
        TransactionController transactionController = getTransactionController();
        transactionController.StartTransaction();
        
        try
        {
            NeuralNetworkJpaController neuralNetworkJpaController = transactionController.getDAOFactoryForTransaction().createNeuralNetworkDAO();
            
            List<NeuralNetwork> neuralNetworks = neuralNetworkJpaController.findNeuralNetworkEntities();
            
            for(NeuralNetwork neuralNetwork1 : neuralNetworks)
            {
                neuralNetwork1.setDefaultNetwork( neuralNetwork1.getNeuralnetworkID().equals(neuralnetwork.getNeuralnetworkID()) );
                neuralNetworkJpaController.edit(neuralNetwork1);
            }
            
            transactionController.CommitTransaction();
        }
        catch(Exception ex)
        {
            transactionController.RollbackTransaction();
            throw ex;
        }
        finally
        {
            transactionController.CloseEntityManagerForTransaction();
        }
    }

    @Override
    public void updateNeuralNetwork(Session session, NeuralNetwork neuralNetwork) throws Exception 
    {
        TransactionController transactionController = getTransactionController();
        transactionController.StartTransaction();
        
        try
        {
            neuralNetwork = transactionController.getDAOFactoryForTransaction().createNeuralNetworkDAO().edit(neuralNetwork);
            
            neuralNetwork.initaliseNetwork();
            
            
            transactionController.CommitTransaction();
        }
        catch(Exception ex)
        {
            transactionController.RollbackTransaction();
            throw ex;
        }
        finally
        {
            transactionController.CloseEntityManagerForTransaction();
        }
    }

    @Override
    public void updateNeuralNetworkSynapses(Session session, NeuralNetwork neuralNetwork) throws Exception 
    {
        TransactionController transactionController = getTransactionController();
        transactionController.StartTransaction();
        
        try
        {
            SynapseJpaController synapseJpaController = transactionController.getDAOFactoryForTransaction().createSynapseDAO();
            
            List<Synapse> synapses = neuralNetwork.getSynapseList();
            
            for(Synapse synapse : synapses)
            {
                synapseJpaController.edit(synapse);
            }
            
            transactionController.CommitTransaction();
        }
        catch(Exception ex)
        {
            transactionController.RollbackTransaction();
            throw ex;
        }
        finally
        {
            transactionController.CloseEntityManagerForTransaction();
        }
    }

    @Override
    public void removeNeuralNetwork(Session session, NeuralNetwork neuralNetwork) throws Exception 
    {
        TransactionController transactionController = getTransactionController();
        transactionController.StartTransaction();
        
        try
        {
            NeuralNetworkJpaController neuralNetworkJpaController = transactionController.getDAOFactoryForTransaction().createNeuralNetworkDAO();
            
            neuralNetworkJpaController.destroy(neuralNetwork.getNeuralnetworkID());
            
            transactionController.CommitTransaction();
        }
        catch(Exception ex)
        {
            transactionController.RollbackTransaction();
            throw ex;
        }
        finally
        {
            transactionController.CloseEntityManagerForTransaction();
        }
    }

    @Override
    public void runNeuralNetwork(Session session, NeuralNetwork neuralNetwork, List<Double> inputVector) throws Exception 
    {
        neuralNetwork.feedForward(inputVector);
    }

    @Override
    public void correctNeuralNetwork(Session session, NeuralNetwork neuralNetwork, List<Double> targetVector) throws Exception 
    {
        neuralNetwork.backPropagate(targetVector);
    }

    @Override
    public List<Double> trainNeuralNetwork(Session session, NeuralNetwork neuralNetwork, List<List<Double>> inputVectorSet, List<List<Double>> targetVectorSet, int noOfEpochs) throws Exception
    {
        List<Double> trainingAccuracies = new ArrayList<Double>();
       
        for(int k = 0; k < noOfEpochs; k++)
        {            
            Double trainingAccuracy = 0.0;       
            
            System.out.println("Training with " + inputVectorSet.toString());
        
            System.out.println("Against with " + targetVectorSet.toString());
            
            for(int i = 0; i < inputVectorSet.size(); i++)
            {
                neuralNetwork.feedForward();
                
                if(wasAbleToClassifyCorrectly(neuralNetwork, targetVectorSet.get(i)))
                {
                    trainingAccuracy++;
                }
                
                neuralNetwork.backPropagate(targetVectorSet.get(i));  
                updateNeuralNetworkSynapses(session, neuralNetwork);
            }
            
            
            
            shuffelVectorSets(inputVectorSet, targetVectorSet);
            trainingAccuracies.add((trainingAccuracy / inputVectorSet.size()) * 100);  
            System.out.println("Epoch " + k + ": " + trainingAccuracies);
        }
        
        return trainingAccuracies;
    }
    
    private boolean wasAbleToClassifyCorrectly(NeuralNetwork neuralNetwork, List<Double> targetVector) throws Exception
    {
        List<Neuron> outputs = neuralNetwork.getAllOutputNeurons();
        
        if(outputs.size() != targetVector.size())
        {
            throw new Exception("Number of output neurons don't match expected number of target fields in vector");
        }        
        
        for(int i = 0; i < outputs.size(); i++)
        {
            if(!outputs.get(i).getActualOutputValue().equals(targetVector.get(i)))
            {
                return false;
            }
        }
        
        return true;
        
    }

    
    private void shuffelVectorSets(List<List<Double>> inputVectorSet, List<List<Double>> targetVectorSet)
    {
        int total = inputVectorSet.size();
        
        List<List<Double>> newInputVectorSet = new ArrayList<List<Double>>();
        List<List<Double>> newTargetVectorSet = new ArrayList<List<Double>>();
        
        List<Integer> indices = new ArrayList<Integer>();
        for(int i = 0; i < total; i++)
        {
            indices.add(i);
        }
        
        for(int i = 0; i < total; i++)
        {
            int indicesIndex = (int) (Math.random() * (indices.size() - 1));
            int index = indices.get(indicesIndex);
            
                        
            newInputVectorSet.add(inputVectorSet.get(index));
            newTargetVectorSet.add(targetVectorSet.get(index));
            indices.remove(indicesIndex);
        }

        inputVectorSet.clear();
        targetVectorSet.clear();
        inputVectorSet.addAll(newInputVectorSet);
        targetVectorSet.addAll(newTargetVectorSet);
    } 
}
