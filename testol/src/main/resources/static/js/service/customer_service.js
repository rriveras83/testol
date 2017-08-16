angular.module('myApp').factory('CustomerService', ['$http', '$q', function ($http, $q) {
    var REST_SERVICE_URI = 'http://localhost:8080/services/customer';

    var factory = {
        fetchAllCustomers: fetchAllCustomers,
        createCustomer: createCustomer,
        updateCustomer: updateCustomer,
        deleteCustomer: deleteCustomer
    }

    return factory;

    function fetchAllCustomers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching Customers')
                    deferred.reject(errResponse)
                }
            );
        return deferred.promise;
    }

    function createCustomer(customer){
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + "/create" , angular.toJson(customer))
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while creatng Customer');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function updateCustomer (customer) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + "/update", customer)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while updating Customer');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
    
    function deleteCustomer (id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+"/"+id)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while deleting Customer');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}])