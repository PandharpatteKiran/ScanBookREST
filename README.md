# ScanBookREST
ScanBook API is a REST web service that allows you to inventory your books. This is developed using Java Spring as the framework and MySQL as the database.

HTTP Methods, URI's and their description:

GET	    /ScanBook/books		          Retrieve All Books
GET	    /ScanBook/books/{barcode} 	Retrieve One Book
POST	  /ScanBook/books 	          Add Book
PUT	    /ScanBook/books/{barcode} 	Update Book
DELETE	/ScanBook/books/{barcode} 	Delete Book

