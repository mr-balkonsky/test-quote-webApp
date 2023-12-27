const url = document.location.origin;
const pathname = document.location.pathname;
const newUserForm = document.querySelector('#newUserForm');
const newUserEmail = document.querySelector('#newUserEmail');
const newUserName = document.querySelector('#newUserName');
const newUserPassword = document.querySelector('#newUserPassword');
const addQuoteForm = document.querySelector('#addQuoteForm');
const quoteContent = document.querySelector('#quoteContent');
const editQuoteForm = document.querySelector('#editQuoteForm');
const editQuoteContent = document.querySelector('#editQuoteContent');
const deleteQuoteForm = document.querySelector('#deleteQuoteForm');
const authForm = document.querySelector('#authForm');
const authEmail = document.querySelector('#authEmail');
const authPassword = document.querySelector('#authPassword');
const userInfo = document.querySelector('#userInfo');
const loginBlock = document.querySelector('#loginBlock');
const userProfile = document.querySelector('#userProfile');
const randomQuote = document.querySelector('#randomQuote');
const topQuotes = document.querySelector('#topQuotes');
const flopQuotes = document.querySelector('#flopQuotes');
const lastQuotes = document.querySelector('#lastQuotes');
const userQuotes = document.querySelector('#userQuotes');
const addQuoteButton = document.querySelector('#addQuoteButton');
const logoutButton = document.querySelector('#logoutButton');
const cancelButton = document.querySelector('#cancelButton');
const token = localStorage.getItem('accessToken');
let userId;

async function renderData() {
    await setAuthUserData();
    await getUserQuotes();
    await getRandomQuote();
    await getTopQuotes();
    await getFlopQuotes();
    await getLastQuotes();
    await setListenerForVote();
    setListenerForLogin();
    setListenerForLogout();
}

async function getScore(block, quotes) {
    let html = '';
    if (block === userQuotes) {
        username = quotes[0].username;
        let id = +pathname[pathname.length - 1];
        const title = userQuotes.querySelector('h5')
        if (id === +userId) {
            title.innerHTML = 'My' + title.innerHTML;
        } else {
            addQuoteButton.remove();
            title.innerHTML = username + title.innerHTML;
        }
    }

    if (Array.isArray(quotes)) {
        for (let quote of quotes) {
            const score = await fetch(`${url}/api/quotes/quote/${quote.id}/score`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(response => {
                if (!response.ok) {
                    throw new Error('Request failed:' + response.status);
                }
                return response.text();
            })

            html += `
                <div id="q_${quote.id}" class="item">
                    <h6>${quote.content}</h6>
                    <h7>Score &nbsp; ${score}</h7>
            `;

            if (token == null) {

            } else  {
                if (block === userQuotes && userId === quote.userId) {
                    html += `
                        <a id="updateQuoteButton" class="update-button" href="${url}/quotes/quote/${quote.id}/edit">edit</a>
                        <a id="deleteQuoteButton" class=" delete-button" href="${url}/quotes/quote/${quote.id}/delete">delete</a>
                    `;
                } else {
                    html += `
                    <button class="vote" type="button">+</button>
                    <button class="vote" type="button">-</button>
                `;
                }
            }

            if (block === userQuotes) {
                html+= `
                    <span class="link-to-profile">${quote.username}</span>
                    <div class="graph"></div>
                </div>     
            `;
            } else {
                html+= `
                    <a class="link-to-profile" href="/user/${quote.userId}">${quote.username}</a>
                    <div class="graph"></div>
                </div>     
            `;
            }
        }
    } else {
        const score = await fetch(`${url}/api/quotes/quote/${quotes.id}/score`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (!response.ok) {
                throw new Error('Request failed:' + response.status);
            }
            return response.text();
        })

        html += `
                <div id="rq_${quotes.id}" class="item">
                    <h6>${quotes.content}</h6>
                    <h7>Score &nbsp; ${score}</h7>
            `;

        if (token == null) {

        } else {
            html += `
                    <button class="vote" type="button">+</button>
                    <button class="vote" type="button">-</button>
            `;
        }

        html+= `
                    <a class="link-to-profile" href="/user/${quotes.userId}">${quotes.username}</a>
                    <div class="graph"></div>
                </div>     
            `;

    }
    block.insertAdjacentHTML('beforeend', html);
}

async function getRandomQuote() {
    return fetch(`${url}/api/quotes/random`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        if (!response.ok) {
            throw new Error('Request failed:' + response.status);
        }
        return response.json();
    }).then(quote => getScore(randomQuote, quote)).catch(error => console.log(error));
}

async function getTopQuotes() {
    if(topQuotes == null) {
        return null;
    } else {
       return fetch(`${url}/api/quotes/top`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (!response.ok) {
                throw new Error('Request failed:' + response.status);
            }
            return response.json();
        }).then(quotes => getScore(topQuotes, quotes)).catch(error => console.log(error));
    }
}

async function getFlopQuotes() {
    if(flopQuotes == null) {
        return null;
    } else {
        return fetch(`${url}/api/quotes/flop`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (!response.ok) {
                throw new Error('Request failed:' + response.status);
            }
            return response.json();
        }).then(quotes => getScore(flopQuotes, quotes)).catch(error => console.log(error));
    }
}

async function getLastQuotes() {
    if(lastQuotes == null) {
        return null;
    } else {
        return fetch(`${url}/api/quotes/last`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (!response.ok) {
                throw new Error('Request failed:' + response.status);
            }
            return response.json();
        }).then(quotes => getScore(lastQuotes, quotes)).catch(error => console.log(error));
    }
}

async function getUserQuotes() {
    if(userQuotes == null) {
        return null;
    } else {
        let id = +pathname[pathname.length - 1];
        let username;
        return fetch(`${url}/api/quotes/user/${id}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (!response.ok) {
                throw new Error('Request failed:' + response.status);
            }
            return response.json();
        }).then(quotes => {
            if (quotes.length === 0) {
                userQuotes.querySelector('h5').innerHTML = "No quotes yet!"
                return null;
            } else {
                getScore(userQuotes, quotes)
            }

        }).catch(error => console.log(error));
    }
}

function setListenerForNewUser() {
    if(newUserForm == null) {
        return null;
    } else {
        newUserForm.addEventListener('submit', e => {
            e.preventDefault();
            fetch(`${url}/api/users`, {
                method:'POST',
                headers:{
                    'Content-Type':'application/json'
                },
                body:JSON.stringify({
                    email:newUserEmail.value,
                    name:newUserName.value,
                    password:newUserPassword.value,
                    creationDate: new Date(),
                    roles: [{id:1, name:"ROLE_USER"}]
                })
            }).then(response => {
                if (!response.ok) {
                    throw new Error('Request failed:' + response.status);
                }
                return response.text();
            }).catch(error => console.log(error));

            window.location.href = `${url}/top`;
        });
    }
}


async function setListenerForAddQuote() {
    if(addQuoteForm == null) {
        return null;
    } else {
        if (token == null) {
            window.location.href = `${url}/top`;
        } else {
            const user = await fetch(`${url}/api/users/user`, {
                method: 'GET',
                headers: {
                    'Authorization': `${token}`,
                    'Content-Type': 'application/json'
                }
            }).then(response => {
                if (!response.ok) {
                    throw new Error('Request failed:' + response.status);
                }
                return response.json();
            }).catch(error => console.log(error));

            addQuoteForm.addEventListener('submit', e => {
                e.preventDefault();

                fetch(`${url}/api/quotes`, {
                    method:'POST',
                    headers:{
                        'Content-Type':'application/json'
                    },
                    body:JSON.stringify({
                        content:quoteContent.value,
                        creationDate: new Date(),
                        updateDate: new Date(),
                        userId: user.id,
                        username: user.name
                    })
                }).then(response => {
                    if (!response.ok) {
                        throw new Error('Request failed:' + response.status);
                    }
                    return response.text();
                }).catch(error => console.log(error));

                window.history.go(-1)
            });
        }
    }
}

function setContentForEditQuote() {
    if(editQuoteForm == null) {
        return null;
    } else {
        if (token == null) {
            window.location.href = `${url}/top`;
        } else {
            const path = location.pathname;

            fetch(`${url}/api${path}`, {
                method:'GET',
                headers:{
                    'Content-Type':'application/json'
                }
            }).then(response => {
                if (!response.ok) {
                    throw new Error('Request failed:' + response.status);
                }
                return response.json();
            }).then(data => {
                console.log(data)
                editQuoteContent.value = data.content;
            }).catch(error => console.log(error));

        }
    }
}

function setListenerForEditQuote() {
    if(editQuoteForm == null) {
        return null;
    } else {
        if (token == null) {
            window.location.href = `${url}/top`;
        } else {
            const path = location.pathname;
            editQuoteForm.addEventListener('submit', e => {
                e.preventDefault();

                fetch(`${url}/api${path}`, {
                    method:'PATCH',
                    headers:{
                        'Content-Type':'application/json'
                    },
                    body:JSON.stringify({
                        content:editQuoteContent.value,
                        updateDate: new Date()
                    })
                }).then(response => {
                    if (!response.ok) {
                        throw new Error('Request failed:' + response.status);
                    }
                    return response.text()
                }).catch(error => console.log(error));

                window.history.go(-1)
            });
        }
    }
}

function setListenerForDeleteQuote() {
    if(deleteQuoteForm == null) {
        return null;
    } else {
        if (token == null) {
            window.location.href = `${url}/top`;
        } else {
            const path = location.pathname;
            deleteQuoteForm.addEventListener('submit', e => {
                e.preventDefault();

                fetch(`${url}/api${path}`, {
                    method:'DELETE',
                    headers:{
                        'Content-Type':'application/json'
                    }
                }).then(response => {
                    if (!response.ok) {
                        throw new Error('Request failed:' + response.status);
                    }
                    return response.text();
                }).catch(error => console.log(error));

                window.history.go(-1)
            });
        }
    }
}

function setListenerForCancelButton() {
    cancelButton.addEventListener('click', e => {
        e.preventDefault();
        window.history.go(-1)
    });
}

function setListenerForLogin () {
    if(authForm == null) {
        return null;
    } else {
        authForm.addEventListener('submit', e => {
            e.preventDefault();

            fetch(`${url}/api/auth/login`, {
                method:'POST',
                headers:{
                    'Content-Type':'application/json'
                },
                body:JSON.stringify({
                    email:authEmail.value,
                    password:authPassword.value
                })
            }).then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            }).then(data => {
                localStorage.setItem('accessToken', data.accessToken);
                window.location.href = '/user/' + data.userId;
            }).catch(error => {
                console.error('Authentication error:', error);
            });
        });
    }
}

async function setAuthUserData() {
    if(token == null) {
        userProfile.remove();
        userInfo.remove();
        return null;
    } else {
        const urlPage = document.URL;

        //set Auth
        await fetch(urlPage, {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            } else loginBlock.remove()})


        //set User Info
        return fetch(`${url}/api/users/user`, {
            method: 'GET',
            headers: {
                'Authorization': `${token}`,
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (!response.ok) {
                throw new Error('Request failed:' + response.status);
            }
            return response.json();
        }).then(user => {
            userInfo.querySelector('h6').innerHTML = `Hello ${user.name}!`
            userId = user.id;
            const profileLink = userProfile.firstElementChild;
            if (userId !== +pathname[pathname.length - 1]) {
                profileLink.setAttribute('href', profileLink.getAttribute("href") + userId)
            } else profileLink.removeAttribute('href');
            fetch(`${url}/api/quotes/by-user-vote/${userId}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(response => {
                if (!response.ok) {
                    throw new Error('Request failed:' + response.status);
                }
                return response.json();
            }).then(quotes => {
                let html = '';
                for (const quote of quotes) {
                    html += `
                    <div class="my-vote">
                        <h6><a class="link-to-quote" href="/user/${quote.userId}">${quote.content.substring(0, 24)}...</a></h6>
                    </div>
                `;
                }
                document.querySelector('.last-votes')
                    .insertAdjacentHTML('beforeend', html);
            })
        })

    }
}

async function setListenerForVote() {
    const buttons = document.querySelectorAll('.vote');
    buttons.forEach(function (button) {
        button.addEventListener('click', vote);
    });

    function vote(event) {
        const currentButton = event.target;
        const quote = currentButton.parentElement.getAttribute('id');
        const quoteId = quote[0] === 'r' ? quote.substring(3) : quote.substring(2);
        const rate = currentButton.textContent === '+' ? 1 : -1

        const quoteUserLink = currentButton.parentElement.querySelector('a');
        let quoteUserid;
        if (quoteUserLink == null) {
            quoteUserid = +pathname[pathname.length - 1];
        } else {
            const quoteUserLinkHref = quoteUserLink.getAttribute('href');
            quoteUserid =  quoteUserLinkHref[quoteUserLinkHref.length - 1];
        }

        if (+quoteUserid === userId) {
            alert('You can’t vote for yourself!');
        } else {
            fetch(`${url}/api/quotes/quote/vote`, {
                method:'POST',
                headers:{
                    'Content-Type':'application/json'
                },
                body:JSON.stringify({
                    quoteId: quoteId,
                    userId: userId,
                    rate: rate,
                    rateDate: new Date()
                })
            }).then(response => {
                if (!response.ok) {
                    throw new Error('Request failed:' + response.status);
                }
                return response.text();
            }).then(data => {
                alert(data.substring(2))
                if (data[0] === '1') {
                    location.reload ();
                }
            }).catch(error => console.log(error));
        }

    }
}

function setListenerForLogout() {
    if (logoutButton == null) {
        return null;
    } else {
        logoutButton.addEventListener('click', e => {
            e.preventDefault();

            localStorage.clear();
            window.location.href = `${url}/top`;
        });
    }
}

if (newUserForm == null && addQuoteForm == null && editQuoteForm == null && deleteQuoteForm == null) {
    renderData().catch(error => console.log(error));
} else {
    setListenerForCancelButton();
    setListenerForNewUser();
    setContentForEditQuote();
    setListenerForEditQuote();
    setListenerForDeleteQuote();
    setListenerForAddQuote().catch(error => console.log(error));
}


