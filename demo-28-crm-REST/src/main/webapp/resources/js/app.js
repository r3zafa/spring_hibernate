let deleteBtn = document.getElementById('deleteBtn');

deleteBtn.addEventListener('click',function(e) {
  let confirmObj =   confirm("Are you sure that you want delete this customer?\n Either OK or Cancel."); 

  if(confirmObj){
      confirmObj;
  } else {
    e.preventDefault();
  }
}, false );

