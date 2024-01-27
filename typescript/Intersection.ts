type Animal = {
    name: string;
  }
  
  type Bear = Animal & { 
    honey: boolean;
  }
  
  const bear:Bear = {
    name:'Some bear',
    honey:false,
  };
  console.log('Bear ',bear);