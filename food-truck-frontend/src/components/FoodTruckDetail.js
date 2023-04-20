
export default function ({ content }) {
    return (
        <div>

            {/* <span>{content.locationId}</span>
            <span>{content.applicant}</span>
            <span>{content.facilityType}</span> */}

            {/* <span id={content.locationId} className='typeStyle'>
                {content.facilityType}
            </span> */}
            <p className='preStyle'>
                {content.applicant}
            </p>
        </div>
    )
}
