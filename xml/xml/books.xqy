for $x in doc("C:\\Users\\Aditya\\Downloads\\Compressed\\SL6\\adblabassignmentsxquerykmeans\\books.xml")/books/book
where $x/price>30
return $x/title
