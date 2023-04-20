import FoodTruck from "./FoodTruckDetail"

export default function ({ myFoodTruckList }) {

    return (
        <>
            {myFoodTruckList.map((e) => (
                <FoodTruck key={e.locationId} content={e} />
            ))}
        </>
    )
}

