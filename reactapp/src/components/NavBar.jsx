import { Link } from "react-router-dom";

function NavBar() {
  return (
    <nav className="navbar">
      <Link to="/">Home</Link>
      <Link to="/add">Add Order</Link>
      <Link to="/orders">View Orders</Link>
    </nav>
  );
}

export default NavBar;
