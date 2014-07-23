
DROP DATABASE IF EXISTS PostDoc_DB;
CREATE DATABASE PostDoc_DB;

USE PostDoc_DB;

CREATE TABLE address (
	_addressID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	_country VARCHAR(50),
	_province VARCHAR(50),
	_town_city VARCHAR(50),
	_street VARCHAR(50),
	_streeNumber INT,
	_roomNumber VARCHAR(50),
	_zip_postalCode CHAR(6),
	
	PRIMARY KEY (_addressID)
) ENGINE=InnoDB;

CREATE TABLE location (
	_locationID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	_institution VARCHAR(250) NOT NULL,
	_faculty VARCHAR(250) NOT NULL,
	_department VARCHAR(250) NOT NULL,
	
	PRIMARY KEY (_locationID)
) ENGINE=InnoDB;

CREATE TABLE person (
	_systemID CHAR(9) NOT NULL,
	_password VARCHAR(50) NOT NULL,
	_title CHAR(10) NOT NULL,
	_fullName VARCHAR(250) NOT NULL,
	_surname VARCHAR(250) NOT NULL,
	_email VARCHAR(50) NOT NULL,
	_telephoneNumber CHAR(20),
	_workNumber CHAR(20),
	_faxNumber CHAR(20),
	_cellphoneNumber CHAR(20),	
	_addressLine1 BIGINT UNSIGNED NOT NULL,
	_upEmployee BOOLEAN NOT NULL,
	_accountStatus ENUM('active','disabled','dorment'),
	_locationID BIGINT UNSIGNED,
	
	PRIMARY KEY (_systemID),
	FOREIGN KEY (_locationID) REFERENCES location(_locationID),
	FOREIGN KEY (_addressLine1) REFERENCES address(_addressID)
) ENGINE=InnoDB;

CREATE TABLE up_employee_information (
	_employeeID CHAR(9) NOT NULL,	
	_physicalAddress BIGINT UNSIGNED NOT NULL,
	_position VARCHAR(50) NOT NULL,
	_dateOfAppointment DATE NOT NULL,
	_appointmentStatus VARCHAR(50) NOT NULL,
	
	PRIMARY KEY (_employeeID),
	FOREIGN KEY (_employeeID) REFERENCES person(_systemID),
	FOREIGN KEY (_physicalAddress) REFERENCES address(_addressID)
) ENGINE=InnoDB;

CREATE TABLE security_role (
	_roleID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	_name VARCHAR(150) NOT NULL,
	_roleMask BIGINT UNSIGNED NOT NULL,
	
	PRIMARY KEY (_roleID)
) ENGINE=InnoDB;

CREATE TABLE person_security_role (
	_personID CHAR(9) NOT NULL,
	_roleID BIGINT UNSIGNED NOT NULL,
	
	PRIMARY KEY (_personID, _roleID),
	FOREIGN KEY (_personID) REFERENCES person(_systemID),
	FOREIGN KEY (_roleID) REFERENCES security_role(_roleID)
) ENGINE=InnoDB;

CREATE TABLE notification (
	_notificationID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	_subject VARCHAR(200),
	_message TEXT,
	_emailStatus ENUM('sent', 'sending', 'disabled'),
	_timestamp DATETIME NOT NULL,
	_senderID CHAR(9) NOT NULL,
	_recieverID	CHAR(9) NOT NULL,
	
	PRIMARY KEY (_notificationID),
	FOREIGN KEY (_senderID) REFERENCES person(_systemID),
	FOREIGN KEY (_recieverID) REFERENCES person(_systemID)
) ENGINE=InnoDB;



CREATE TABLE application (
    _applicationID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    _type ENUM('new', 'renewal'),
    _status ENUM('open', 'submitted', 'declined', 'refereed', 'finalised', 'recommended', 'endorsed', 'eligible', 'funded', 'completed', 'terminated'),
    _timestamp DATETIME NOT NULL,
    _finalisationDate DATETIME,
    _eligiblityCheckDate DATETIME,
    _startDate DATE,
    _endDate DATE,
    _projectTitle VARCHAR(250),
    _information TEXT,
    _fellow CHAR(9) NOT NULL,
    _grantHolderID CHAR(9) NOT NULL,
    PRIMARY KEY (_applicationID),
    FOREIGN KEY (_fellow) REFERENCES person (_systemID),
    FOREIGN KEY (_grantHolderID) REFERENCES person (_systemID)
)  ENGINE=InnoDB;



CREATE TABLE recommendation_report (
	_reportID BIGINT UNSIGNED NOT NULL,
	_hodID CHAR(9) NOT NULL,
	_timestamp DATETIME NOT NULL,
	_content TEXT NOT NULL,

	PRIMARY KEY (_reportID),
	FOREIGN KEY (_reportID) REFERENCES application(_applicationID),
	FOREIGN KEY (_hodID) REFERENCES person(_systemID)
) ENGINE=InnoDB;

CREATE TABLE endorsement (
	_endorsementID BIGINT UNSIGNED NOT NULL,
	_deanID CHAR(9) NOT NULL,
	_timestamp DATETIME NOT NULL,
	_rank INT UNSIGNED NOT NULL,
	_motivation TEXT NOT NULL,

	PRIMARY KEY (_endorsementID),
	FOREIGN KEY (_endorsementID) REFERENCES application(_applicationID),
	FOREIGN KEY (_deanID) REFERENCES person(_systemID)
) ENGINE=InnoDB;

CREATE TABLE funding_report (
	_reportID BIGINT UNSIGNED NOT NULL,
	_drisID CHAR(9) NOT NULL,
	_timestamp DATETIME NOT NULL,
	_fellowshipCost FLOAT,
	_travelCost FLOAT,
	_runningCost FLOAT,
	_operatingCost FLOAT,
	_equipmentCost FLOAT,
	_conferenceCost FLOAT,

	PRIMARY KEY (_reportID),
	FOREIGN KEY (_reportID) REFERENCES application(_applicationID),
	FOREIGN KEY (_drisID) REFERENCES person(_systemID)
) ENGINE=InnoDB;


CREATE TABLE referee_application (
	_refereeID CHAR(9) NOT NULL,
	_applicationID BIGINT UNSIGNED NOT NULL,
	
	PRIMARY KEY (_refereeID, _applicationID),
	FOREIGN KEY (_refereeID) REFERENCES person(_systemID),
	FOREIGN KEY (_applicationID) REFERENCES application(_applicationID)
) ENGINE=InnoDB;
#CREATE TABLE NEW_applicationS (
#	_applicationID BIGINT UNSIGNED NOT NULL,
#	
#	PRIMARY KEY (_applicationID),
#	FOREIGN KEY (_applicationID) REFERENCES applicationS(_applicationID)
#);

CREATE TABLE referee_report (
	_reportID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	_refereeID CHAR(9) NOT NULL,
	_applicationID BIGINT UNSIGNED NOT NULL,
	_timestamp DATETIME NOT NULL,
	_content TEXT NOT NULL,
	
	PRIMARY KEY (_reportID),
	FOREIGN KEY (_applicationID) REFERENCES application(_applicationID),
	FOREIGN KEY (_refereeID) REFERENCES person(_systemID)
) ENGINE=InnoDB;

CREATE TABLE progress_report (
	_reportID BIGINT UNSIGNED AUTO_INCREMENT,
	_applicationID BIGINT UNSIGNED NOT NULL,
	_timestamp DATETIME NOT NULL,
	_content TEXT NOT NULL,
	
	PRIMARY KEY (_reportID),
	FOREIGN KEY (_applicationID) REFERENCES application(_applicationID)
) ENGINE=InnoDB;

#CREATE TABLE RENEWAL_applicationS (
#	_applicationID BIGINT UNSIGNED NOT NULL,
	
#	PRIMARY KEY (_applicationID),
#	FOREIGN KEY (_applicationID) REFERENCES applicationS(_applicationID)
#);

CREATE TABLE committee_meeting (
	_meetingID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	_startDate DATETIME NOT NULL,
	_endDate DATETIME NOT NULL,
	PRIMARY KEY (_meetingID)
) ENGINE=InnoDB;

CREATE TABLE minute_comment (
	_commentID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	_meetingID BIGINT UNSIGNED NOT NULL,
	_timestamp DATETIME NOT NULL,
	_attendeeID CHAR(9) NOT NULL,
	_comment VARCHAR(500) NOT NULL,
	
	PRIMARY KEY (_commentID),
	FOREIGN KEY (_meetingID) REFERENCES committee_meeting(_meetingID),
	FOREIGN KEY (_attendeeID) REFERENCES person(_systemID)
) ENGINE=InnoDB;

#CREATE TABLE NEW_applicationS_COMMITT_MEETINGS (
#	_meetingID BIGINT UNSIGNED NOT NULL,
#	_newApplicationID BIGINT UNSIGNED NOT NULL,
#	
#	PRIMARY KEY (_meetingID, _newApplicationID),
#	FOREIGN KEY (_meetingID) REFERENCES committee_meetingS(_meetingID),
#	FOREIGN KEY (_newApplicationID) REFERENCES NEW_applicationS(_applicationID)
#);

#CREATE TABLE RENEWAL_applicationS_COMMITT_MEETINGS (
#	_meetingID BIGINT UNSIGNED NOT NULL,
#	_renewalApplicationID BIGINT UNSIGNED NOT NULL,
	
#	PRIMARY KEY (_meetingID, _renewalApplicationID),
#	FOREIGN KEY (_meetingID) REFERENCES committee_meetingS(_meetingID),
#	FOREIGN KEY (_renewalApplicationID) REFERENCES RENEWAL_applicationS(_applicationID)
#);

CREATE TABLE attendence_list (	
	_meetingID BIGINT UNSIGNED NOT NULL,
	_attendeeID CHAR(9) NOT NULL,
	
	PRIMARY KEY (_meetingID, _attendeeID),
	FOREIGN KEY (_meetingID) REFERENCES committee_meeting(_meetingID),
	FOREIGN KEY (_attendeeID) REFERENCES person(_systemID)
) ENGINE=InnoDB;

CREATE TABLE committee_meetings_applications (
	_meetingID BIGINT UNSIGNED NOT NULL,
	_applicationID BIGINT UNSIGNED NOT NULL,
	
	PRIMARY KEY (_meetingID, _applicationID),
	FOREIGN KEY (_meetingID) REFERENCES committee_meeting(_meetingID),
	FOREIGN KEY (_applicationID) REFERENCES application(_applicationID)
) ENGINE=InnoDB;


CREATE TABLE audit_log (
	_entryID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	_personID CHAR(9) NOT NULL,
	_timestamp DATETIME NOT NULL,
	_action VARCHAR(100) NOT NULL,
	
	PRIMARY KEY (_entryID),
	FOREIGN KEY (_personID) REFERENCES person(_systemID)
) ENGINE=InnoDB;

CREATE TABLE cv (
	_cvID CHAR(9) NOT NULL,
	_idNumber CHAR(20) NOT NULL,
	_dateOfBirth DATE NOT NULL,
	_gender ENUM('male','female'),
	_citizenship CHAR(50),
	_nrfRating CHAR(4),
	_race CHAR(20),
	_recentInstitution VARCHAR(50),
	_researchOutput TEXT,
	_otherContributions TEXT,
	_additionalInformation TEXT,

	PRIMARY KEY(_cvID),
	FOREIGN KEY (_cvID) REFERENCES person(_systemID)
) ENGINE=InnoDB;

CREATE TABLE academic_qualification (
	_qualificationID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	_cvID CHAR(9) NOT NULL,
	_name VARCHAR(100),
	_fieldOfStudy VARCHAR(100),
	_instituation VARCHAR(100),
	_yearObtained DATE,
	_distinctions TINYINT UNSIGNED,

	PRIMARY KEY (_qualificationID),
	FOREIGN KEY (_cvID) REFERENCES cv(_cvID)
) ENGINE=InnoDB;

CREATE TABLE experience (
	_experienceID BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	_cvID CHAR(9) NOT NULL,
	_capacity VARCHAR(100),
	_organisation VARCHAR(100),
	_startDate DATETIME NOT NULL,
	_endDate DATETIME NOT NULL,
	
	PRIMARY KEY (_experienceID),
	FOREIGN KEY (_cvID) REFERENCES cv(_cvID)
) ENGINE=InnoDB;


INSERT INTO postdoc_db.security_role (_name, _roleMask) VALUES("Prospective fellow",0), 
															("Referee",1),
															("Research fellow",2),
															("Grant holder",3),
															("HOD", 4),
															("Dean's office member",5),
															("DRIS member", 6), 
															("Post doctoral Committee member",7), 
															("System administrator",8);

INSERT INTO postdoc_db.address (_country) VALUES("TestMainia");
INSERT INTO postdoc_db.person (_systemID,_fullName,_password,_title,_surname,_email,_addressLine1,_UpEmployee,_accountStatus) VALUES ('u12019837','Test','test','Mr','Tester','test@gmail.com',1,false, 'active');
INSERT INTO postdoc_db.person_security_role (_personID, _roleID) VALUES ('u12019837',1),
																		('u12019837',2),
																		('u12019837',3),
																		('u12019837',4),
																		('u12019837',5),
																		('u12019837',6),
																		('u12019837',7),
																		('u12019837',8),
																		('u12019837',9);






