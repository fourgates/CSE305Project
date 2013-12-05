CREATE TABLE Circle (
    Circle_Id INTEGER,
    Circle_NAME VARCHAR(100),
    Owner_Of_Circle INTEGER NOT NULL,
    Type VARCHAR(50),
    PRIMARY KEY (Circle_Id),
    FOREIGN KEY (Owner_Of_Circle)
        REFERENCES User (User_Id)
        ON DELETE NO ACTION,
    CHECK (Circle_Id > 0)
);
 
CREATE TABLE User (
    SSN INTEGER NOT NULL,
    User_Id INTEGER,
    Account_Creation_Date DATETIME NOT NULL,
    Rating INTEGER,
    PRIMARY KEY (User_Id),
    CHECK (User_Id > 0),
    FOREIGN KEY (SSN)
        REFERENCES Person (SSN)
        ON DELETE CASCADE
);

CREATE TABLE AddedTo (
    User_Id INTEGER NOT NULL,
    Circle_Id INTEGER NOT NULL,
    PRIMARY KEY (User_Id , Circle_Id),
    FOREIGN KEY (User_Id)
        REFERENCES User (User_Id)
        ON DELETE NO ACTION,
    FOREIGN KEY (Circle_Id)
        REFERENCES Circle (Circle_Id)
        ON DELETE NO ACTION
);

CREATE TABLE Account (
    Account_Number INTEGER,
    Account_Creation_Date DATETIME NOT NULL,
    Credit_Card_Number INTEGER,
    Status VARCHAR(10),
    PRIMARY KEY (Account_Number),
    CHECK (Account_Number > 0)
);
 
CREATE TABLE User_Has_Account (
    User_Id INTEGER NOT NULL,
    Account_Number INTEGER NOT NULL,
    PRIMARY KEY (User_id , Account_Number),
    FOREIGN KEY (Account_Number)
        REFERENCES Account (Account_Number)
        ON DELETE NO ACTION,
    FOREIGN KEY (User_Id)
        REFERENCES User (User_Id)
        ON DELETE NO ACTION
);
 
CREATE TABLE User_Preferences (
    Id INTEGER NOT NULL,
    Preference VARCHAR(50),
    PRIMARY KEY (Id , Preference),
    FOREIGN KEY (Id)
        REFERENCES User (User_Id)
        ON DELETE NO ACTION
);
 
CREATE TABLE Message (
    Message_Id INTEGER,
    Date DATETIME NOT NULL,
    Subject VARCHAR(50),
    Content VARCHAR(1000),
    Sender INTEGER NOT NULL,
    Receiver INTEGER NOT NULL,
    PRIMARY KEY (Message_Id),
    CHECK (Message_Id > 0),
    FOREIGN KEY (Sender)
        REFERENCES User (User_Id)
        ON DELETE NO ACTION,
    FOREIGN KEY (Receiver)
        REFERENCES User (User_Id)
        ON DELETE NO ACTION
);

CREATE TABLE Person (
    SSN INTEGER,
    Last_Name VARCHAR(50),
    First_Name VARCHAR(50),
    Address VARCHAR(100),
    City VARCHAR(50),
    State VARCHAR(50),
    Zip_Code INTEGER,
    Telephone INTEGER,
    Email_Address VARCHAR(50),
    PRIMARY KEY (SSN),
    CHECK (SSN > 0)
);
 
CREATE TABLE Employee (
    SSN INTEGER NOT NULL,
    Start_Date DATETIME NOT NULL,
    Hourly_Rate INTEGER,
    Manager INTEGER NOT NULL,
    PRIMARY KEY (SSN),
    FOREIGN KEY (Manager)
        REFERENCES Manager (SSN)
        ON DELETE NO ACTION,
    FOREIGN KEY (SSN)
        REFERENCES Person (SSN)
        ON DELETE CASCADE
);
 
CREATE TABLE Manager (
    SSN INTEGER,
    Start_Date DATETIME NOT NULL,
    Hourly_Rate INTEGER,
    PRIMARY KEY (SSN),
    FOREIGN KEY (SSN)
        REFERENCES Person (SSN)
        ON DELETE CASCADE
);
 
CREATE TABLE Post (
    Post_Id INTEGER,
    Date DATETIME NOT NULL,
    Content VARCHAR(50),
    Comment_Count INTEGER,
    Circle INTEGER NOT NULL,
    Author INTEGER NOT NULL,
    PRIMARY KEY (Post_Id),
    FOREIGN KEY (Circle)
        REFERENCES Circle (Circle_Id)
        ON DELETE NO ACTION,
    FOREIGN KEY (AUTHOR)
        REFERENCES User (User_Id)
        ON DELETE NO ACTION,
    CHECK (Post_Id > 0 AND Comment_Count >= 0)
);
 
CREATE TABLE Comment (
    Comment_Id INTEGER,
    Date DATETIME NOT NULL,
    Content VARCHAR(50),
    Post INTEGER NOT NULL,
    Author INTEGER NOT NULL,
    PRIMARY KEY (Comment_Id),
    CHECK (Comment_Id > 0),
    FOREIGN KEY (Post)
        REFERENCES Post (Post_Id)
        ON DELETE NO ACTION,
    FOREIGN KEY (AUTHOR)
        REFERENCES User (User_Id)
        ON DELETE NO ACTION
);
 
CREATE TABLE User_Likes_Post (
    User INTEGER NOT NULL,
    Post INTEGER NOT NULL,
    PRIMARY KEY (User , Post),
    FOREIGN KEY (User)
        REFERENCES User (User_Id)
        ON DELETE NO ACTION,
    FOREIGN KEY (Post)
        REFERENCES Post (Post_Id)
        ON DELETE NO ACTION
);
 
CREATE TABLE User_Likes_Comment (
    User INTEGER NOT NULL,
    Comment INTEGER NOT NULL,
    PRIMARY KEY (User , Comment),
    FOREIGN KEY (User)
        REFERENCES User (User_Id)
        ON DELETE NO ACTION,
    FOREIGN KEY (Comment)
        REFERENCES Comment (Comment_Id)
        ON DELETE NO ACTION
);
 
CREATE TABLE Advertisement (
    Advertisement_Id INTEGER,
    Employee INTEGER NOT NULL,
    Type VARCHAR(50),
    Date DATETIME NOT NULL,
    Company VARCHAR(50),
    Item_Name VARCHAR(50),
    Content VARCHAR(50),
    Unit_Price INTEGER,
    Availabe_Units INTEGER,
    PRIMARY KEY (Advertisement_Id),
    CHECK (Advertisement_Id > 0),
    FOREIGN KEY (Employee)
        REFERENCES Employee (SSN)
        ON DELETE NO ACTION
);
 
CREATE TABLE Purchase (
    Transaction_Id INTEGER,
    Date DATETIME NOT NULL,
    Advertisement INTEGER NOT NULL,
    Number_Of_Units INTEGER,
    Account INTEGER NOT NULL,
    User INTEGER NOT NULL,
    PRIMARY KEY (Transaction_Id),
    CHECK (TRANSACTION_Id > 0),
    FOREIGN KEY (Advertisement)
        REFERENCES Advertisement (Advertisement_Id)
        ON DELETE NO ACTION,
    FOREIGN KEY (User , Account)
        REFERENCES User_Has_Account (User_Id , Account_Number)
        ON DELETE NO ACTION
);
