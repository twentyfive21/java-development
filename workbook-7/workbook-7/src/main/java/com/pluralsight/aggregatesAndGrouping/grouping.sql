-- page 71 exercise
1. SELECT COUNT(*) FROM northwind.Suppliers;
2. SELECT SUM(Salary) FROM northwind.Employees;
3. SELECT MIN(UnitPrice) FROM northwind.Products;
4. SELECT AVG(UnitPrice) FROM northwind.Products;
5. SELECT MAX(UnitPrice) FROM northwind.Products;
6. SELECT SupplierID, UnitsInStock FROM northwind.Products;
7. SELECT CategoryID, AVG(UnitPrice) FROM northwind.Products GROUP BY CategoryID;
8. SELECT SupplierID, COUNT(SupplierID) AS Total FROM northwind.Products GROUP BY supplierID HAVING Total >= 5;
9. SELECT ProductID, ProductName, (UnitPrice * UnitsInStock) as Total FROM northwind.Products ORDER BY Total DESC, ProductName;