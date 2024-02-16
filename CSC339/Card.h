#pragma once
#include <ostream>

enum class Value { Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace };
enum class Suit { Clubs, Diamonds, Hearts, Spades };
class Card
{
private:
	Value value;
	Suit suit;
public:
	Card(Value v, Suit s);
	Value getValue() const;
	Suit getSuit() const;
	std::string getStringValue() const;
	std::string getStringSuit() const;
	bool sameSuit(const Card& other) const;
	friend bool operator==(const Card& lhs, const Card& rhs);
	friend bool operator<(const Card& lhs, const Card& rhs);
	friend bool operator>(const Card& lhs, const Card& rhs);
	friend std::ostream& operator<<(std::ostream& s, const Card& c);
};