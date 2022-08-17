import React, { useState, useEffect } from 'react';
import axios from 'axios';
import {Form,FormGroup,Label,Input, Button,Container}from 'reactstrap';

import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './card.css'
const CardComponents = () => {

  const [users, setusers] = useState([]);
  let navigate = useNavigate();
    useEffect(() => {
    fetchUser();
    }, []);

    const handle =()=>{
        // props.logFun();
        navigate("/login")
  
     }
    const fetchUser = () => {
        axios
            .get('http://localhost:9090/api/v1/users')
            .then((res) => {
            console.log(res);
            setusers(res.data);
            })
            .catch((err) => {
            console.log(err);
            });
};

const handleSubmit = (e) => {
  e.preventDefault();

  const formdata = new FormData(e.target);
  
  axios.post('http://localhost:9090/api/v1/users/createNew/', {
  "id": formdata.get('id'),
  "name": formdata.get('name'),
  "age": formdata.get('age'),
}).then((res) =>{
  toast.success('User Added Successfull!!', {
     position: "top-center",
     autoClose: 1000,
    hideProgressBar: false,
    closeOnClick: true,
    pauseOnHover: true,
     draggable: true,
    progress: undefined,
    });
    setTimeout(function(){
      window.location.reload(1);
   }, 1000);    
   
})
.catch(function (error){
  console.log(error);
   toast.error('Something went wrong!!', {
     position: "top-center",
     autoClose: 2000,
    hideProgressBar: false,
    closeOnClick: true,
    pauseOnHover: true,
     draggable: true,
    progress: undefined,
    })
    setTimeout(function(){
      window.location.reload(1);
   }, 6000);
})          
}

function Delete(id){

    axios.delete('http://localhost:9090/api/v1/users/deleteCall/'+id)

    .then((res)=>{
        toast.success('User Deleted Successfull!!', {
           position: "top-center",
           autoClose: 2000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
           draggable: true,
          progress: undefined,
          })
          setTimeout(function(){
           window.location.reload(1);
        }, 2000);
     })

     .catch(function (error){
        console.log(error);
         toast.error('Something went wrong!!', {
           position: "top-center",
           autoClose: 3000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
           draggable: true,
          progress: undefined,
          })
     });
    }

    return (
    <div>
       <Form  onSubmit={handleSubmit}>
       <table className="tableapp">
        <tr>
          <th><FormGroup>
              <Label for="id">ID: </Label>
              <Input type="number" id="id" name="id" /> 
              </FormGroup></th>
                    <th><FormGroup>
              <Label for="name">Name: </Label>
              <Input type="text" id="name" name="name" /> 
              </FormGroup></th>
                    <th><FormGroup>
              <Label for="age">Age: </Label>
              <Input type="number" id="age" name="age" />
              </FormGroup></th>
        </tr>
        <tr>    <Button type="submit" color="primary" >Add User</Button>
</tr>

        </table>
      </Form>
<br></br>
      <div className="tableapp">
      <table>
        <tr>
          <th>Name</th>
          <th>Age</th>
          <th>Gender</th>
	    <th>Action</th>
        </tr>
        {users.map((user, key) => {
          return (
            <tr key={user.id}>
              <td>{user.id}</td>
              <td>{user.name}</td>
              <td>{user.age}</td>
              <td><Button  color='danger' onClick={()=>Delete(user.id)}
                  > Delete user </Button></td>

            </tr>
          )
        })}
      </table>
            <ToastContainer></ToastContainer>

    </div>
    </div>
     );
};
export default CardComponents;