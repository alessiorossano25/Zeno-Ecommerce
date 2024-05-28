const drop_button = document.querySelector('#menu-item-1');
const sub_menu = document.querySelector('.submenu');


drop_button.onclick = () => {
  sub_menu.classList.toggle('show');
};


document.addEventListener('click', (event) => {
  
  if (!event.target.closest('.submenu') && !event.target.closest('#menu-item-1')) {
    
    sub_menu.classList.remove('show');
  }
});





const drop_button2 = document.querySelector('#menu-item-2');
const sub_menu2 = document.querySelector('.submenu2');


drop_button2.onclick = () => {
  sub_menu2.classList.toggle('show');
};

document.addEventListener('click', (event) => {
  
  if (!event.target.closest('.submenu2') && !event.target.closest('#menu-item-2')) {
    
    sub_menu2.classList.remove('show');
  }
});






const drop_button3 = document.querySelector('#menu-item-3');
const sub_menu3 = document.querySelector('.submenu3');

drop_button3.onclick = () => {
  sub_menu3.classList.toggle('show');
};

document.addEventListener('click', (event) => {
  
  if (!event.target.closest('.submenu3') && !event.target.closest('#menu-item-3')) {
    
    sub_menu3.classList.remove('show');
  }
});









function togglePassword() {
  var passwordInput = document.getElementById("myInput");
  var eyeIcon = document.getElementById("eyeIcon");

  if (passwordInput.type === "password") {
      passwordInput.type = "text"; // Mostra i caratteri reali
      eyeIcon.classList.remove("fa-eye");
      eyeIcon.classList.add("fa-eye-slash");
  } else {
      passwordInput.type = "password"; // Nasconde i caratteri
      eyeIcon.classList.remove("fa-eye-slash");
      eyeIcon.classList.add("fa-eye");
  }
}

function subtogglePassword() {
  var subpasswordInput = document.getElementById("sub-password");
  var eyeIcon = document.getElementById("eyeIcon1");

  if (subpasswordInput.type === "password") {
      subpasswordInput.type = "text"; // Mostra i caratteri reali
      eyeIcon.classList.remove("fa-eye");
      eyeIcon.classList.add("fa-eye-slash");
  } else {
      subpasswordInput.type = "password"; // Nasconde i caratteri
      eyeIcon.classList.remove("fa-eye-slash");
      eyeIcon.classList.add("fa-eye");
  }
}


function disableSubmit() {
  document.getElementById("submit").classList.add('btn-danger')

  document.getElementById("submit").disabled = true;
 }

  function activateButton(element) {
    
      if(element.checked) {
        document.getElementById("submit").classList.remove('btn-danger');
        document.getElementById("submit").classList.add('btn-primary')

        document.getElementById("submit").disabled = false;
       }
       else  {
        document.getElementById("submit").classList.remove('btn-primary');

        document.getElementById("submit").classList.add('btn-danger')

        document.getElementById("submit").disabled = true;

      } 
  }



  



  let slider = document.querySelector(".slider");
  let currentSlide = 0;
  let totalSlides = slider.querySelectorAll(".wrapper .left > div").length-1;

  slider.querySelector(".controls .up").addEventListener("click", function(){
    if(currentSlide == 0){
      return;
    }
    currentSlide--;
    slider.querySelector(".wrapper .left div").style.marginTop = `${currentSlide*-100}vh`;
    slider.querySelector(".wrapper .right div").style.marginTop = `${(totalSlides - currentSlide)*-100}vh`;
  });
  

  slider.querySelector(".controls .down").addEventListener("click", function(){
    if(currentSlide == totalSlides){
      return;
    }
    currentSlide++;
   
    slider.querySelector(".wrapper .left div").style.marginTop = `${currentSlide*-100}vh`;
    slider.querySelector(".wrapper .right div").style.marginTop = `${(totalSlides - currentSlide)*-100}vh`;

  });