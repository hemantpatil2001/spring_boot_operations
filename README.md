## API Documentation

### Database: `employee_db`

#### 1. Save Employee Data
- **Table Name**: `employee`
- **API Description**: Save Employee Data
- **API Method**: POST
- **API Endpoint**: [http://localhost:8080/e1/employee](http://localhost:8080/e1/employee)
- **API JSON / Parameters**:
    ```json
    {
      "name": "Hemant Patil",
      "designation": "Java Developer",
      "employeeCode": "BET11",
      "contactNo": "1234567890",
      "isActive": 1,
      "insertDateTime": "" // The insert date and time will be automatically set to the current time in db.
    }
    ```

#### 2. Get All Employee Data
- **API Description**: Retrieve all employee data
- **API Method**: GET
- **API Endpoint**: [http://localhost:8080/e1/employee](http://localhost:8080/e1/employee)

#### 3. Get Employee Data By ID
- **API Description**: Retrieve employee data by ID
- **API Method**: GET
- **API Endpoint**: [http://localhost:8080/e1/employee/{id}](http://localhost:8080/e1/employee/cfd79a42-04ed-4022-a77f-e4c8b8324acc)
- **Example ID**: `cfd79a42-04ed-4022-a77f-e4c8b8324acc`

#### 4. Delete Employee Data By ID
- **API Description**: Delete employee data by ID
- **API Method**: DELETE
- **API Endpoint**: [http://localhost:8080/e1/employee/{id}](http://localhost:8080/e1/employee/e16eaaab-f276-4510-8e6b-e1eeb34da6a8)
- **Example ID**: `e16eaaab-f276-4510-8e6b-e1eeb34da6a8`

#### 5. Get Employee Data By Employee Code
- **API Description**: Retrieve employee data by employee code
- **API Method**: GET
- **API Endpoint**: [http://localhost:8080/e1/employee/by-employee-code?employeeCode={code}](http://localhost:8080/e1/employee/by-employee-code?employeeCode=BET11)
- **Example Employee Code**: `BET11`
