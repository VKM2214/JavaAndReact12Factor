
import React from "react";
import { Button } from 'reactstrap';

export default function ButtonFeature(props){
    return (
        <Button type="type" color={props.color}>{props.text}</Button>
      );
}