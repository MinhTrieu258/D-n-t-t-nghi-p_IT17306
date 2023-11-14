const app = angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl", function($scope, $http){

    // Gio hang
    $scope.cart = {
        items: [],

        // add shopcart
        add(id){
            var item = this.items.find(item => item.id == id);
            if (item) {
                item.qty++;
                this.saveToLocalStorage(); // luu vao

            }
            else{
                $http.get(`/rest/cars/${id}`).then(resp =>{
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    
                    this.saveToLocalStorage();
                    alert("Ban da them vo thanh cong");
                })
            }
           
        },
        //Xoas san pham khoi gio hang
    remove(id){
        var index = this.items.findIndex(item => item.id == id);
        this.items.splice(index, 1);
        this.saveToLocalStorage();
      },
  
      // Xao sach cac mat hang trong gio
  
      clear(){
        this.items=[]
        this.saveToLocalStorage();
      },
  
         get count(){
            return this.items.map(item => item.qty)
            .reduce((total, qty) => total += qty, 0);
         },
         get amount(){
            return this.items.map(item => item.qty * item.price)
            .reduce((total, qty) => total += qty, 0);
         },

         
            // Luu gio hang vao storage
            saveToLocalStorage(){
             var json = JSON.stringify(angular.copy(this.items));
      localStorage.setItem("cart", json);
            },

            loadFormLocalStorage(){
                var json = localStorage.getItem("cart");
                this.items = json ? JSON.parse(json):[];
            }
    }
     $scope.cart.loadFormLocalStorage();



});