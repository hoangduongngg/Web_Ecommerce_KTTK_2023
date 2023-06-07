async function updateProduct() {
    const file = document.getElementById('file-input');
    const img = file.files[0];
    var id = window.location.pathname.split('/')[3];
    const name = document.getElementById('name').value
    const price = document.getElementById('price').value
    const units = document.getElementById('units').value
    const exp = document.getElementById('exp').value
    const description = document.getElementById('description').value

    var formData = new FormData()
    formData.append('img', img)
    formData.append('id', id)
    formData.append('name', name)
    formData.append('price', price)
    formData.append('units', units)
    formData.append('expirationDate', exp)
    formData.append('description', description)
    console.log(id)
    console.log(units)

    var product = await fetch('http://localhost:8081/update-product-img', {
        method: 'POST',
        body: formData,

    })

    if (product.ok) {
        alert("Cập nhật thành công")
    } else {
        alert("Cập nhật thất bại")
    }
}
