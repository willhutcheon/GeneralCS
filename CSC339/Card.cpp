#include "Card.h"

Card::Card(Value v, Suit s) : value(v), suit(s) {}
Value Card::getValue() const
{
    return value;
}
Suit Card::getSuit() const
{
    return suit;
}
std::string Card::getStringValue() const
{
    switch (value)
    {
    case Value::Two: return "Two";
    case Value::Three: return "Three";
    case Value::Four: return "Four";
    case Value::Five: return "Five";
    case Value::Six: return "Six";
    case Value::Seven: return "Seven";
    case Value::Eight: return "Eight";
    case Value::Nine: return "Nine";
    case Value::Ten: return "Ten";
    case Value::Jack: return "Jack";
    case Value::Queen: return "Queen";
    case Value::King: return "King";
    case Value::Ace: return "Ace";
    }
}
std::string Card::getStringSuit() const
{
    switch (suit)
    {
    case Suit::Clubs: return "Clubs";
    case Suit::Spades: return "Spades";
    case Suit::Hearts: return "Hearts";
    case Suit::Diamonds: return "Diamonds";
    }
}
std::ostream& operator<<(std::ostream& s, const Card& c)
{
    s << c.getStringValue() << " of " << c.getStringSuit();
    return s;
}
bool operator==(const Card& lhs, const Card& rhs)
{
    return lhs.value == rhs.value;
}
bool operator<(const Card& lhs, const Card& rhs)
{
    return lhs.value < rhs.value;
}
bool operator>(const Card& lhs, const Card& rhs)
{
    return lhs.value > rhs.value;
}
bool Card::sameSuit(const Card& other) const
{
    return suit == other.suit;
}