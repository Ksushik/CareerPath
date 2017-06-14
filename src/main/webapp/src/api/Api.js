import fetch from "isomorphic-fetch";

function checkStatus(response) {
  if (response.status >= 200 && response.status < 300) {
    return response;
  } else {
    return Promise.reject(response);
  }
}

function handleError(response) {
  if (response instanceof Response) {
    return new Promise((resolve, reject) => {
      response.json().then(error => {
        reject(new Error(error.message));
      });
    });
  }
  return Promise.reject(response);
}


const doRequest = (baseUrl, path, reqType, data) =>
  fetch(`${baseUrl}${HOME}/${path}`, {
    method: reqType,
    credentials: "same-origin",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(data)
  });


export const  getAllSkills = (baseUrl, path, reqType) =>
  doRequest(baseUrl, path, reqType)
    .then(checkStatus)
    .then(response => response.json())
    .catch(handleError);