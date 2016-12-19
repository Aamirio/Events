# Events

EventsConsumer retrieves events from eventfulapi.com

WeatherConsumer retrieves weather up to next 16 days by latitude
and longitude from OpenWeatherAPI.

EventsService merges data from both sources into a 
EventAndForecast object and returns it as a list in an
Events wrapper object

EventsService is provisioned at an endpoint via the
EventsController.

Tests have been written successfully for the consumers and service.

If I had more time I would also write tests for the endpoint.
