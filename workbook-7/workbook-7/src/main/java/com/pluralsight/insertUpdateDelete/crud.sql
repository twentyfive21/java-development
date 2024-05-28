1. INSERT INTO Suppliers VALUES (30, 'Teal Diamonds', 'Hilton Patrick', 'Owner',
'123 new world', 'London', null, 122, 'Japan', '111-111-1111', null, null);

2. INSERT INTO Products VALUES(78,'Pizza', 30, 6, '100 Boxes', 15.99,100,50,100,1);

3. SELECT * FROM northwind.Products;

4. UPDATE Products
   SET UnitPrice = 18.39
   WHERE ProductID = 78;

5. SELECT * FROM northwind.Products WHERE SupplierID = 30;

6. DELETE
   FROM Products
   WHERE ProductID = 78;

7. DELETE FROM Suppliers
   WHERE SupplierID = 30;

8. SELECT * FROM northwind.Products;

9. SELECT * FROM northwind.Suppliers;