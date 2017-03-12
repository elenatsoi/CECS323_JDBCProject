/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Elena
 * Created: Mar 11, 2017
 */

CREATE TABLE WRITINGGROUP(
    groupName VARCHAR(20) NOT NULL,
    headWriter VARCHAR(30),
    yearFormed DATE,
    subject VARCHAR(20),
    CONSTRAINT pk_writinggroup PRIMARY KEY (groupName)
);

CREATE TABLE PUBLISHER(
    publisherName VARCHAR(30) NOT NULL,
    publisherAddress VARCHAR(20),
    publisherPhone VARCHAR(10),
    publisherEmail VARCHAR(30),
    CONSTRAINT pk_publisher PRIMARY KEY (PUBLISHERNAME)
);

CREATE TABLE BOOK(
    groupName VARCHAR(20),
    bookTitle VARCHAR(50) NOT NULL,
    publisherName VARCHAR(30),
    yearPublisher DATE,
    numberPages INT,
    PRIMARY KEY (groupName, bookTitle),
    CONSTRAINT fk_writinggroup FOREIGN KEY (groupName)
    REFERENCES WRITINGGROUP(groupName)
);