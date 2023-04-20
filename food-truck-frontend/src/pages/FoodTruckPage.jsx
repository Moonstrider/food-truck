import { useState, useEffect } from "react";

import RequestSending from "../../config/RequestSending";
import UrlConfig from "../../config/UrlConfig";

export default function FoodTruckPage() {

  const [diaryList, setDiaries] = useState([]);

  useEffect(() => {
    getDiaryList();
  }, []);

  const getDiaryList = async () => {
    const diaryFromServer = await fetchDiaryList();
    if (null == diaryFromServer) {
      setDiaries([]);
    } else {
      setDiaries(diaryFromServer);
    }
  };

  // fetch diaryList from server
  const fetchDiaryList = async () => {
    // fetch dbjson server first
    const resFromDBJSON = await fetch("http://localhost:3100/diaryList");
    const dataFromDBJSON = await resFromDBJSON.json();
    // update into backend server
    await addDiaryListToDB(JSON.stringify(dataFromDBJSON));

    // get from backend server
    const res = await RequestSending("GET", UrlConfig.allDiary);
    const { data } = await res.json();
    return data;
  };

  return (
    <div>
      {
        diaryList.length > 0
          ?
          <DiaryList
            myDiaries={diaryList}
            tryDelete={deleteDiary}
            tryToggle={toggleReminder}
            tryEdit={editDiary}
          />
          :
          <h1>No diary yet</h1>
      }
    </div>
  );
}

