/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Elena
 * Created: Mar 12, 2017
 */

--List all writing groups
SELECT groupName FROM writingGroups;


--List all the data for a group specified by the user (gName)
SELECT * FROM writingGroups WHERE groupName = gName;


--List all publishers
SELECT publisherName FROM publishers;


--List all the data for a publisher specified by the user (pName)
SELECT * FROM publishers WHERE publisherName = pName;


--List all the book titles
SELECT bookTitle FROM books;


--List all the data for a book specified by the user
--This includes all the data for the associated publisher and writing group.
SELECT * FROM books
NATURAL JOIN writingGroups 
NATURAL JOIN publishers
WHERE bookTitle = bTitle;

--OR
SELECT * FROM books 
INNER JOIN writingGroups USING (groupName)
INNER JOIN publishers USING (publisherName)
WHERE bookTitle = bTitle;

--Insert a new book
--Retrieve and store information necessary
--Variables: gName, pName, bTitle, yearPub, pages
INSERT INTO books() VALUES (gName, bTitle, pName, yearPub, pages);


--Insert a new publisher and update all books published by one publisher to be
--published by the new publisher.
--This requirement is two separate operations.  The idea is that a new publisher
--(xyz) buys out an existing publisher (abc).  After the new publisher is added
--to the database, all books that are currently published by abc will now be
--published by xyz.