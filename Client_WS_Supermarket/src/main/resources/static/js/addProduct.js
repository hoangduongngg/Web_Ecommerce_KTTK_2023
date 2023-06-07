async function addProduct() {
    const file = document.getElementById('file-input');
    const img = file.files[0];
    const name = document.getElementById('name').value
    const price = document.getElementById('price').value
    const units = document.getElementById('units').value
    const exp = document.getElementById('exp').value
    const description = document.getElementById('decription').value

    var formData = new FormData()
    formData.append('img', img)
    formData.append('name', name)
    formData.append('price', price)
    formData.append('units', units)
    formData.append('expirationDate', exp)
    formData.append('description', description)

    var product = await fetch('http://localhost:8081/add-product-img', {
        method: 'POST',
        body: formData,

    })
        
    if (product.ok) {
        alert("Thêm thành công")
    } else {
        alert("Tên sản phẩm bị trùng")
    }
}
