document.getElementById("id-photo").addEventListener("change", function (e) {
  const file = e.target.files[0];
  const reader = new FileReader();
  reader.onload = function (e) {
    const img = new Image();
    img.src = e.target.result; 
    const qrData = { nume: "Buza", prenume: "Dan", idnp: "2004500019528" }; 
    document.getElementById("f-name").value = qrData.nume;
    document.getElementById("second-name").value = qrData.prenume;
    document.getElementById("personal-id").value = qrData.idnp;
  };
  reader.readAsDataURL(file);
});
