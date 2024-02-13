class Present {
    constructor(containerElement) {
        this.containerElement = containerElement;
        // Create image and append to container.
        const image = document.createElement('img');
        image.src = 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1083533/gift-icon.png';
        image.addEventListener('click', this._openPresent);
        this.containerElement.append(image);
    }
    _openPresent(event) {
        const image = event.currentTarget;
        image.src = 'https://media.giphy.com/media/27ppQUOxe7KlG/giphy.gif';
        image.removeEventListener('click', this._openPresent);
    }
}