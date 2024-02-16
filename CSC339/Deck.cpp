#include "Deck.h"
#include "Card.h"
#include <algorithm>

Deck::Deck(std::default_random_engine& gen)
    : gen(gen)
{
    this->gen = gen;
    for (int suit = static_cast<int>(Suit::Clubs); suit <= static_cast<int>(Suit::Spades); suit++)
    {
        for (int value = static_cast<int>(Value::Two); value <= static_cast<int>(Value::Ace); value++)
        {
            trueHome.push_back(std::make_unique<Card>(static_cast<Value>(value), static_cast<Suit>(suit)));
        }
    }
    std::shuffle(trueHome.begin(), trueHome.end(), gen);
    for (auto& card : trueHome)
    {
        drawPile.push(card.get());
    }
    reshuffle();
}
void Deck::reshuffle()
{
    std::shuffle(trueHome.begin(), trueHome.end(), gen);
    std::stack<Card*> tempStack;
    for (auto& card : trueHome)
    {
        tempStack.push(card.get());
    }
    drawPile.swap(tempStack);
}
Card* Deck::draw()
{
    if (!drawPile.empty()) {
        Card* topCard = drawPile.top();
        drawPile.pop();
        return topCard;
    }
    return nullptr;
}