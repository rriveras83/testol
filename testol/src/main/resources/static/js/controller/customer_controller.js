angular.module('myApp').controller('CustomerController', ['$scope', 'CustomerService', function ($scope, CustomerService) {
    var self = this;
    self.customer={id:null, name:'', address:'',phone:''};
    self.customers=[];
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

    fetchAllCustomers();

    function fetchAllCustomers() {
        CustomerService.fetchAllCustomers()
            .then(
                function (d) {
                    self.customers = d;
                },
                function (errResponse) {
                    console.error('Error while fetching Customers');
                }
            );
    }

    function createCustomer(customer) {
        CustomerService.createCustomer(customer)
            .then(
                fetchAllCustomers,
                function (errResponse) {
                    console.error('Error while creating Customer');
                }
            );
    }

    function updateCustomer(customer, id){
        CustomerService.updateCustomer(customer, id)
            .then(
                fetchAllCustomers,
                function (errResponse) {
                    console.error('Error while updating Customer');
                }
            );
    }

    function deleteCustomer(id) {
        CustomerService.deleteCustomer(id)
            .then(
                fetchAllCustomers,
                function (errResponse) {
                    console.error('Error while deleting Customer');
                }
            );
    }

    function submit() {
        if(self.customer.id===null){
            console.log('Saving new Customer', self.customer);
            createCustomer(self.customer);
        }else{
            updateCustomer(self.customer);
            console.log('Customer update with id ', self.customer.id)
        }
        reset();
    }

    function edit(id) {
        console.log('id to be edited', id);
        for(var i = 0; i < self.customers.length; i++){
            if(self.customers[i].id === id){
                self.customer = angular.copy(self.customers[i]);
                break;
            }
        }
    }

    function remove(id) {
        console.log('id to be deleted', id);
        if(self.customer.id === id){
            reset();
        }
        deleteCustomer(id);
    }

    function reset() {
        self.customer={id:null,name:'',address:'',phone:''};
        $scope.myForm.$setPristine();
    }
}])