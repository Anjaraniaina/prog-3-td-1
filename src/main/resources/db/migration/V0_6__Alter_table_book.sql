INSERT INTO author (name) SELECT author FROM book;
update book SET author_id=author.id FROM author WHERE author.name=book.author;
ALTER TABLE book DROP COLUMN author;