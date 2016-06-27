(function(window,document){
	var ligerUiFn = function(){};
	ligerUiFn.prototype = {
			constructor:ligerUiFn,
			
	}
	ligerUiFn = {
			itemClick:function(item){
				console.log(this)
			    switch(item.id){
			    	case "save":
			    		ligerUiFn.save();
			    		break;
			    	case "back":
			    		ligerUiFn.back();
			    		break;
			    	case "add":
			    		ligerUiFn.addGridRow();
			    		break;
			    	case "modify":
			    		ligerUiFn.modifyGridRow();
			    		break;
			    	case "refresh":
			    		ligerUiFn.refresh();
			    		break;
			    	case "delete":
			    		ligerUiFn.deleteGridRow();
			    	default : break;
			    }
			},
			addGridRow:function(){
				
			},
			modifyGridRow:function(){
				
			},
			back:function(url){
				location.href=url;
			},
			refresh:function(){
				location.reload()
			},
			save:function(){
				alert("重寫")
			},
			deleteGridRow:function(){
				
			}
	}
	window.ligerUiFn = ligerUiFn;
})(window,document)