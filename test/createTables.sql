/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Elena
 * Created: Mar 11, 2017
 */

drop table WRITINGGROUP;
drop table PUBLISHER;
drop table BOOK;

CREATE TABLE WRITINGGROUPS(
    groupName VARCHAR(20) NOT NULL,
    headWriter VARCHAR(30),
    yearFormed DATE,
    subject VARCHAR(20),
    CONSTRAINT pk_writinggroup PRIMARY KEY (groupName)
);

CREATE TABLE PUBLISHERS(
    publisherName VARCHAR(30) NOT NULL,
    publisherAddress VARCHAR(20),
    publisherPhone VARCHAR(10),
    publisherEmail VARCHAR(30),
    CONSTRAINT pk_publisher PRIMARY KEY (publisherName)
);

CREATE TABLE BOOKS(
    groupName VARCHAR(20) NOT NULL,
    bookTitle VARCHAR(50) NOT NULL,
    publisherName VARCHAR(30) NOT NULL,
    yearPublished DATE,
    numberPages INT,
    CONSTRAINT pk_book PRIMARY KEY (groupName, bookTitle),
    CONSTRAINT fk_writinggroup FOREIGN KEY (groupName) REFERENCES WRITINGGROUPS(groupName),
    CONSTRAINT fk_publisher FOREIGN KEY (publisherName) REFERENCES PUBLISHERS(publisherName)
);