-- page 75 exercise nested queries
1. SELECT ProductName, UnitPrice FROM northwind.Products WHERE UnitPrice = (SELECT MAX(UnitPrice) from northwind.Products);
2. SELECT OrderID, ShipName, ShipAddress FROM northwind.Orders WHERE ShipVia = (SELECT shipperID from Shippers WHERE CompanyName = 'Federal Shipping');
3. SELECT orderID FROM northwind.`Order Details` WHERE ProductID = (SELECT ProductID WHERE productID = 34);
4. SELECT * FROM northwind.Employees WHERE EmployeeID = (SELECT EmployeeID FROM northwind.Orders WHERE orderID = 10266);
5. SELECT * FROM northwind.Customers WHERE CustomerID = (SELECT CustomerID FROM northwind.Orders WHERE OrderID = 10266);

