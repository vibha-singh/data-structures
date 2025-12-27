Car Rental System
- User Onboarding (Registration)
- Car Onboarding (Registration)
- Discovery of Vehicles (Available vehicles, Search based on start and end location, vehicle type)
- Booking system: Reservations, payment processing, and cancellations.
- Scalability: Handling large fleets and customer demand.

User: user_id, name, emailId, password, username
Payment: payment_id, user_id, vehicle_id, status
Vehicle: vehicle_id, name, type, registeredOn, 
Address: id, centre_name, city, state, pincode, 
Registered_Vehicle: registered_id, vehicle_id, min_rate, status(registered), pick_up_point(address_id)
, drop_point()
User_Bookings: vehicle_id, 


Vehicle_Availability: vehicle_id, date, available
Booked_Vehicle: booking_id,vehicle_id, date_to, date_from, start, destination, booked_amount


User Bookings: booking_id, user_id, payment_status, booking_status(booked, cancelled, serving, completed)
Database:


start location -> counter

Criteria: 
1) vehicle type
2) to and from
3) rates

/api/v1/availableVehicles - vehcile_type, rate,

car onboarding:
1) car details: Sedan, all the car papers, licence of driver, 

Service:
1) CarOnboarding
2) UserOnboarding
3) SearchVehicle
4) Booking
5) PaymentProcessing
6) RegisterPoints (adding more pickup and drop points)

Design Pattern:



