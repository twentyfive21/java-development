1. SELECT * FROM northwind.Products;
2. SELECT ProductID, ProductName, UnitPrice FROM northwind.Products;
3. SELECT ProductID, ProductName, UnitPrice FROM northwind.Products ORDER BY UnitPrice;
4. SELECT ProductID, ProductName, UnitPrice FROM northwind.Products WHERE UnitPrice <= 7.50;
5. SELECT * FROM northwind.Products WHERE UnitsInStock >= 100 ORDER BY UnitPrice DESC;
6. SELECT * FROM northwind.Products WHERE UnitsInStock >= 100 ORDER BY UnitPrice DESC, ProductName;
7. SELECT * FROM northwind.Products WHERE UnitsInStock = 0 && UnitsOnOrder >= 1 ORDER BY ProductName;
8. SELECT * FROM northwind.Categories; -- The name is categories
9. SELECT * FROM northwind.Categories; -- Seafood id is 8
10. SELECT * FROM northwind.Products WHERE CategoryID = 8; -- it does it by putting the category id in the column
11. SELECT * FROM northwind.Employees; -- In the employees table
12. SELECT * FROM northwind.Employees WHERE Title LIKE '%manager%';
13. SELECT DISTINCT(TITLE) FROM northwind.Employees;
14. SELECT * FROM Employees WHERE Salary BETWEEN 2000 AND 2500;
15. SELECT * FROM northwind.Suppliers;
-- Tokyo supplier id is 4
16. SELECT * FROM northwind.Products WHERE SupplierID = 4;
