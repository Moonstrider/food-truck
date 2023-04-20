
export default function ({ foodTruck }) {
    return (
        <div>

            {/* <span>{foodTruck.locationId}</span> */}
            <span>{foodTruck.applicant}</span>
            <span>{foodTruck.facilityType}</span>

            {/* <span id={diaryContent.id} className='timeStyle'>
                {diaryContent.day}
            </span>
            <pre className='preStyle'>
                {diaryContent.text}
            </pre> */}
        </div>
    )
}
