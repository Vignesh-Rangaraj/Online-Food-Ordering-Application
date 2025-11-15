// src/components/OrderList.jsx
import React,{useState,useEffect} from 'react';
import api from "../utils/api";

function OrderList({refresh}) {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    api.get("/orders").then((res) => setOrders(Array.isArray(res.data) ? res.data : []));
  }, [refresh]);

  const deleteOrder = async (id) => {
    await api.delete(`/orders/${id}`);   // NOTE: backticks, not quotes
    setOrders((prev) => prev.filter((o) => o.id !== id));
  };

  return (
    <div className="orders-container">
      <h2>All Orders</h2>
      <ul>
        {orders.length === 0 && <p>No orders available</p>}
        {orders.map((o) => (
          <li key={o.id}>
            <strong>{o.menuItemName}</strong>{" - "}
            <span>{o.restaurantName}</span>{" - "}
            <em>{o.orderStatus}</em>{" "}
            <button onClick={() => deleteOrder(o.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}
export default OrderList;
