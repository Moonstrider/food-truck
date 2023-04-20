import UrlConfig from "./UrlConfig";

function RequestSending(method, urlSuffix, param) {
  return fetch(UrlConfig.local + urlSuffix, {
    method: method,
    headers: {
      "Content-type": "application/json",
    },
    body: param,
  });
};


export default RequestSending;
