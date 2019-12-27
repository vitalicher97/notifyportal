CREATE TABLE Agreement(
	AgrID int NOT NULL,
	Agr_Name text,
	Comp_Name text,
	Exp_Date date,
	PRIMARY KEY (AgrID)
);

CREATE TABLE Persons(
	PersID int NOT NULL,
	Name text,
	Email text,
	PRIMARY KEY (PersID),
);

CREATE TABLE Docs(
	DocID int NOT NULL,
	Doc_Name text,
	AgrID int NOT NULL,
	PersID int NOT NULL,
	Notify_Sent bit,
	PRIMARY KEY (DocID),
	FOREIGN KEY (AgrID) REFERENCES Agreement(AgrID),
	FOREIGN KEY (PersID) REFERENCES Persons(PersID)
);

INSERT INTO Agreement
VALUES ('License prolongation on Adobe CC', 'Soft Online', '2020-01-06');
INSERT INTO Aggreement
VALUES ('License prolongation on WORD 2016', 'Soft Online', '2019-12-11');


