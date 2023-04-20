import { useState, useEffect } from "react";

import RequestSending from "../config/RequestSending";
import UrlConfig from "../config/UrlConfig";
import FoodTruckList from "../components/FoodTruckList"

export default function FoodTruckPage() {

  const [foodTruckList, setFoodTruckList] = useState([]);

  useEffect(() => {
    getFoodTruckList();
  }, []);

  const getFoodTruckList = async () => {
    const foodTruckFromServer = await fetchFoodTruckList();
    if (null == foodTruckFromServer) {
      setFoodTruckList([]);
    } else {
      setFoodTruckList(foodTruckFromServer);
    }
    console.log('bbb,',foodTruckFromServer)
    console.log('aaa,',foodTruckList)
  };

  const fetchFoodTruckList = async () => {
    // get from backend server
    const res = await RequestSending("GET", UrlConfig.allFoodTruck);
    console.log('res:',res)
    const { data } = await res.json();
    console.log('data:',data)
    return data;
  };

  return (
    <div>
      {
        foodTruckList.length > 0
          ?
          <FoodTruckList myFoodTruckList={foodTruckList}/>
          :
          <h1>No food truck yet</h1>
      }
    </div>
  );
}

