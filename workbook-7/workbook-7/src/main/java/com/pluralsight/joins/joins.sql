-- https://www.codeproject.com/Articles/33052/Visual-Representation-of-SQL-Joins
1. SELECT ProductID, ProductName, UnitPrice, CategoryName FROM northwind.Products
 JOIN Categories ON products.CategoryID = Categories.CategoryID
 ORDER BY CategoryName, ProductName;

2. SELECT ProductID, ProductName, UnitPrice, CompanyName FROM northwind.Products
JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID WHERE UnitPrice > 75
ORDER BY ProductName;

3. SELECT ProductID, ProductName, UnitPrice, CategoryName, CompanyName FROM northwind.Products
JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID JOIN Categories ON
Products.CategoryID = Categories.CategoryID ORDER BY ProductName;

--
4. SELECT ProductName, CategoryName, UnitPrice FROM northwind.Products JOIN Categories
ON Products.CategoryID = Categories.CategoryID WHERE UnitPrice
= (SELECT MAX(UnitPrice) FROM Northwind.Products as p WHERE p.CategoryID = Categories.categoryID);
--

5. SELECT OrderID, ShipName, ShipAddress, CompanyName FROM
 northwind.Orders JOIN Shippers ON Orders.ShipVia = Shippers.ShipperID
 WHERE ShipCountry = 'Germany';

6. SELECT Orders.OrderID, Orders.OrderDate, Orders.ShipName, Orders.ShipAddress
   FROM northwind.Orders
   JOIN northwind.`Order Details` as Details ON Orders.OrderID = Details.OrderID
   JOIN Products ON Details.ProductID = Products.ProductID WHERE Products.ProductID = 34;