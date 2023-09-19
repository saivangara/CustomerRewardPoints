// TransactionList.js
import { useState } from 'react';

const TransactionList = () => {
  const [customerId, setCustomerId] = useState('');
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const [rewardPoints, setRewardPoints] = useState(null);

  const calculateRewardPoints = async () => {
      
      try {
        const response = await fetch(`http://localhost:8080/transactions/${customerId}?startDate=${startDate}&endDate=${endDate}`);
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const result = await response.json();
        setRewardPoints(result);
      } catch (error) {
        console.error('Fetch error:', error);
      }
  };

  return (
    <div>
      <h2>Calculate Reward Points</h2>
      <div>
        <input
          type="text"
          value={customerId}
          onChange={(e) => setCustomerId(e.target.value)}
          placeholder="Customer ID"
        />
        <input
          type="date"
          value={startDate}
          onChange={(e) => setStartDate(e.target.value)}
        />
        <input
          type="date"
          value={endDate}
          onChange={(e) => setEndDate(e.target.value)}
        />
        <button onClick={calculateRewardPoints}>Calculate Reward Points</button>
      </div>
      {rewardPoints !== null && (
        <p>Total Reward Points: {rewardPoints}</p>
      )}
    </div>
  );
};

export default TransactionList;
