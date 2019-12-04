### Index
**[getmyfreeweeklygame](https://github.com/qgeffard/getmyfreeweeklygame/blob/master/README.md#getmyfreeweeklygame)**</br>
**[Méthode Login](https://github.com/qgeffard/getmyfreeweeklygame/blob/master/README.md#m%C3%A9thode-login)**</br>
**[Méhode 1](https://github.com/qgeffard/getmyfreeweeklygame/blob/master/README.md#m%C3%A9hode-1)**</br>

# getmyfreeweeklygame
- Goal :
''Here you can find a script that will automatically add the free weekly epicgames to your library''

# Méthode Login
- Allez sur l'url https://www.epicgames.com/id/login
- Récup  `<input>` avec `id="email"`
- Récup  `<input>` avec `id="password"`
- Récup `<button>` avec `id="login"`
- Saisir l'email dans`<input>` avec `id="email"`
- Saisir le mot de pass dans `<input>` avec `id="password"`
- Clic sur le `<button>` avec `id="login"`
- Récup `<button>` avec `class="btn btn-primary"`
- Clic sur le `<button>` avec `class="btn btn-primary"`

:Logo_Alpha: 
# Méhode 1
- Go to https://www.epicgames.com/store/fr
- Récupe `"span"` Gratuit maintenant
- on remonte de 3 élément parent (jusque au `<a aria-label>`)
- Dans le `<a aria-label>` on récup le contenue de `href=""`
- Ce rendre à l'url que le`href=""` contient
- Récup le `PurchaseButton-button`
- Clic sur le `PurchaseButton-button`
