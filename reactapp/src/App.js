import React, { useState } from "react";
import AddOrder from "./components/AddOrder";
import OrderList from "./components/OrderList";
import "./App.css";

export default function App() {
  const [refresh, setRefresh] = useState(false);
  const handleOrderAdded = () => setRefresh((prev) => !prev);

  return (
    <div>
      <h1>Online Food Order System</h1>
      <p>Online Food Ordering Portal</p>

      <AddOrder onOrderAdded={handleOrderAdded} />
      <OrderList refresh={refresh} />
    </div>
  );
}
