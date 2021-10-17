# fiap-mba

SQL scripts execution order:

* address_create.sql
* person_create.sql
* person_addresses_create.sql
* procedure_create.sql
* person_specialties_create.sql
* treatment_create.sql
* appointment_create.sql
* procedure_insert.sql
* professional_insert.sql
* patient_insert.sql
* address_insert.sql
* person_address_insert.sql

RESTful URLs:

* GET - /clintech/professional/list - Get all professionals
* GET - /clintech/procedure/list - Get all procedures
* POST - /clintech/patient - Insert a new patient. JSON:

```
{
      "name": "Chris",
      "lastname": "Bellamy",
      "email": "chris.bellamy@gmail.com",
      "phone": "(11)98235-3698",
      "address": [{
      		"street": "Rua Independencia",
	          "number": 358,
	          "district": "Perdizes",
	          "city": "Sao Paulo",
			"state": "SP",
	          "zipCode": "02384-157"
      	}]
   }
```

* GET - /clintech/patient/id - Get a patient by ID (replace the word 'id' by the id number)
* POST - /clintech/appointment - Insert/Update an appointment. To update, just add the id property to the JSON string. JSON:

```
{
      "date": "30/10/2021",
	   "time": "09:30",
      "professional": { "id": 2 },
      "treatment": {
          "procedure": { "id": 1 },
          "patient": { "id": 7 }
      }
}
```
* GET - /clintech/appointment/list/id - Get all appointments by patient ID (replace the word 'id' by the id number)
* GET - /clintech/appointment/id - Get appointment by ID (replace the word 'id' by the id number)
* DELETE - /clintech/appointment/id - Delete the appointment by ID (replace the word 'id' by the id number)
