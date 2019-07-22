curl -X POST "http://10.20.0.170:8765/company/loginCompany" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"password\": \"p\", \"userName\": \"p\"}" | python -m json.tool 
