import React, { useState, useEffect } from "react";
function UserList() {
 const [users, setUsers] = useState([]);
 const [loading, setLoading] = useState(true);
 const [error, setError] = useState(null);
 useEffect(() => {
fetch("http://localhost:8085/api/users")
.then((res) => res.json())
.then((data) => {
setUsers(data);
setLoading(false);
})
.catch((err) => {
setError("Failed to fetch users");
setLoading(false);
});
}, []);
 if (loading) return <p>Loading API users...</p>;
 if (error) return <p>Error: {error}</p>;
 return (
 <div className="container">
 <h2>Users from API</h2>
 {users.map((user) => (
 <div key={user.id} className="card">
 <h4>{user.name}</h4>
 <p>Email: {user.email}</p>
 <p>Phone: {user.phone}</p>
 </div>
 ))}
 </div>
 );
}
export default UserList;