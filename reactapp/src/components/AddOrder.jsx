import React, { useState } from "react";
import api from "../utils/api";

export default function AddOrder({ onOrderAdded = () => {} }) {
  const [form, setForm] = useState({
    restaurantName: "",
    cuisineType: "",
    menuItemName: "",
    menuItemDescription: "",
    menuItemPrice: "",
    quantity: "",
    orderStatus: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  const isEmpty = (v) => !v || String(v).trim() === "";

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (
      isEmpty(form.restaurantName) ||
      isEmpty(form.cuisineType) ||
      isEmpty(form.menuItemName) ||
      isEmpty(form.menuItemDescription) ||
      isEmpty(form.menuItemPrice) ||
      isEmpty(form.quantity) ||
      isEmpty(form.orderStatus)
    ) {
      return;
    }

    await api.post("/orders", {
      ...form,
      menuItemPrice: parseFloat(form.menuItemPrice),
      quantity: parseInt(form.quantity, 10),
    });

    setForm({
      restaurantName: "",
      cuisineType: "",
      menuItemName: "",
      menuItemDescription: "",
      menuItemPrice: "",
      quantity: "",
      orderStatus: "",
    });

    onOrderAdded();
  };

  return (
    <form onSubmit={handleSubmit}>
      <input placeholder="Restaurant Name" name="restaurantName" value={form.restaurantName} onChange={handleChange} />
      <input placeholder="Cuisine Type" name="cuisineType" value={form.cuisineType} onChange={handleChange} />
      <input placeholder="Menu Item Name" name="menuItemName" value={form.menuItemName} onChange={handleChange} />
      <input placeholder="Item Description" name="menuItemDescription" value={form.menuItemDescription} onChange={handleChange} />
      <input type="number" placeholder="Price" name="menuItemPrice" value={form.menuItemPrice} onChange={handleChange} />
      <input type="number" placeholder="Quantity" name="quantity" value={form.quantity} onChange={handleChange} />
      <input placeholder="Order Status" name="orderStatus" value={form.orderStatus} onChange={handleChange} />

      <button type="submit">Submit Order</button>
    </form>
  );
}
