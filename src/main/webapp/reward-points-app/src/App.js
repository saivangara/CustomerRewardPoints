// App.js
import React from 'react';
import TransactionList from './TransactionList'; // Import the TransactionList component

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>My Reward Points App</h1>
      </header>
      <main>
        {/* Render the TransactionList component here */}
        <TransactionList />
      </main>
    </div>
  );
}

export default App;
