Assignment

This project contains these endpoints implementation:
1. **/api/v1/auth/register**

   This endpoint is used for onboarding new users

   Payload: {
    "email": "akhil@gmail.com",
    "password": "akhil"
   }

   Response: {
     "token": "eyJhbGciOiJIUzI1Ni....."
   }

2. **/api/v1/auth/authenticate**

   This endpoint is used to authenticate the payload using EMAIL and PASSWORD.

   Payload: {
    "email": "akhil@gmail.com",
    "password": "akhil"
   }

   Response: {
     "token": "eyJhbGciOiJIUzI1Ni....."
   }

3. **/api/v1/upload**

   This endpoint is used for uploading images to S3.

   Headers: {"Token": "eyJhbGciOiJIUzI1Ni....." }
  
   Payload: {'file=@"/Users/lakhv/Desktop/Sample_Image.png"'}
  
   Response: "https://sample.upload.com/images/Sample_Image.png"

4. **/api/v1/user/update**

   This endpoint is used to update user info after the image is uploaded successfully.

   Headers: {"Token": "eyJhbGciOiJIUzI1Ni....." }
  
   Payload: {
           "email": "akhil@gmail.com",
           "profileImage": "https://sample.upload.com/images/Sample_Image.png",
           "name": "akhil"
    }
  
    Response: {
            "name": "akhil",
            "email": "akhil@gmail.com"
    }

 5. **/api/v1/user/get-all?pageNumber=1&pageSize=4** 

    This endpoint is used to fetch all user's data with paginated support.

    Headers: {"Token": "eyJhbGciOiJIUzI1Ni....." }

    Params: pageNumber-> Long, pageSize -> Long

    Response: [
        {
            "name": "Sachin",
            "email": "sachin8@gmail.com"
        },
        {
            "name": "Sumit",
            "email": "sumit@gmail.com"
        },
        {
            "name": "aman",
            "email": "aman@gmail.com"
        },
        {
            "name": "akhil",
            "email": "akhil@gmail.com"
        }
    ]
    

   
